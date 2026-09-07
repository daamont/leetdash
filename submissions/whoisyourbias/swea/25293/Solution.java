import java.util.BitSet;
import java.util.HashMap;


class UserSolution {

		int N;
		int K;

		// 역 -> 해당 역에 정차하는 열차 idx
		BitSet[] stationToTrain;

		// 열차 idx -> 환승 가능한 열차 idx
		BitSet[] trainToTransferringTrain;

		// 사용 중인 열차 내부 idx
		BitSet usedIdx;

		// 실제 열차 ID -> Train
		HashMap<Integer, Train> trainIdToTrain;

		class Train {
			int mId;
			int sId;
			int eId;
			int mInterval;
			int idx;

			Train(int mId, int sId, int eId, int mInterval, int idx) {
				this.mId = mId;
				this.sId = sId;
				this.eId = eId;
				this.mInterval = mInterval;
				this.idx = idx;
			}
		}

		public void init(
				int N,
				int K,
				int mId[],
				int sId[],
				int eId[],
				int mInterval[]) {
			this.N = N;
			this.K = K;

			usedIdx = new BitSet(200);

			stationToTrain = new BitSet[N + 1];

			trainToTransferringTrain = new BitSet[200];

			for (int i = 0; i < 200; i++) {
				trainToTransferringTrain[i] = new BitSet(200);
			}

			trainIdToTrain = new HashMap<>();

			for (int i = 0; i < K; i++) {
				add(
						mId[i],
						sId[i],
						eId[i],
						mInterval[i]);
			}
		}

		public void add(
				int mId,
				int sId,
				int eId,
				int mInterval) {

			int idx = usedIdx.nextClearBit(0);

			Train train = new Train(
					mId,
					sId,
					eId,
					mInterval,
					idx);

			/*
			 * 새 열차와 환승 가능한 기존 열차들
			 */
			BitSet connected = new BitSet(200);

			for (int station = sId; station <= eId; station += mInterval) {

				// 아직 어떤 열차도 정차하지 않는 역일 수 있음
				if (stationToTrain[station] != null) {
					connected.or(stationToTrain[station]);
				}
			}

			/*
			 * 새 열차 -> 기존 열차
			 */
			trainToTransferringTrain[idx].clear();
			trainToTransferringTrain[idx].or(connected);

			/*
			 * 기존 열차 -> 새 열차
			 */
			for (int other = connected.nextSetBit(0); other >= 0; other = connected.nextSetBit(other + 1)) {

				trainToTransferringTrain[other].set(idx);
			}

			/*
			 * 역 -> 새 열차 등록
			 */
			for (int station = sId; station <= eId; station += mInterval) {

				if (stationToTrain[station] == null) {
					stationToTrain[station] = new BitSet(200);
				}

				stationToTrain[station].set(idx);
			}

			usedIdx.set(idx);

			trainIdToTrain.put(mId, train);
		}

		public void remove(int mId) {

			Train train = trainIdToTrain.remove(mId);

			int idx = train.idx;

			/*
			 * 역에서 해당 열차 제거
			 */
			for (int station = train.sId; station <= train.eId; station += train.mInterval) {

				stationToTrain[station].clear(idx);
			}

			/*
			 * 다른 열차들의 환승 관계에서 제거
			 */
			for (int other = usedIdx.nextSetBit(0); other >= 0; other = usedIdx.nextSetBit(other + 1)) {

				trainToTransferringTrain[other].clear(idx);
			}

			trainToTransferringTrain[idx].clear();

			usedIdx.clear(idx);
		}

		public int calculate(int sId, int eId) {

			BitSet start = stationToTrain[sId];
			BitSet end = stationToTrain[eId];

			if (start == null ||
					end == null ||
					start.isEmpty() ||
					end.isEmpty()) {

				return -1;
			}

			/*
			 * 같은 열차로 직통 가능
			 */
			if (start.intersects(end)) {
				return 0;
			}

			BitSet visited = (BitSet) start.clone();
			BitSet frontier = (BitSet) start.clone();

			int transfer = 0;

			while (!frontier.isEmpty()) {

				BitSet next = new BitSet(200);

				/*
				 * 현재 탈 수 있는 모든 열차에서
				 * 환승 가능한 열차를 전부 합침
				 */
				for (int cur = frontier.nextSetBit(0); cur >= 0; cur = frontier.nextSetBit(cur + 1)) {

					next.or(trainToTransferringTrain[cur]);
				}

				next.andNot(visited);

				transfer++;

				if (next.intersects(end)) {
					return transfer;
				}

				visited.or(next);
				frontier = next;
			}

			return -1;
		}
	}