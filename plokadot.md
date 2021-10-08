# Plotadot

波卡网络采用分片模型，分片叫做平行链(parachain)。每一个平行链有一个状态转移函数(STF)。
波卡有一个中继链(Relay Chain)


## 角色
 ###　验证者
 被选中进入验证者集合，才能成本验证者，生成中继链区块，获取奖励。
Validators, if elected to the validator set, produce blocks on the Relay Chain. They also accept proofs of valid state transition from collators. In return, they will receive staking rewards.
### 校对者（参与者）
Collators are full nodes on both a parachain and the Relay Chain. They collect parachain transactions and produce state transition proofs for the validators on the Relay Chain. They can also send and receive messages from other parachains using XCMP.

### 提名者（质押者）
Nominators bond their stake to particular validators in order to help them get into the active validator set and thus produce blocks for the chain. In return, nominators are generally rewarded with the portion of the staking rewards from that validator.