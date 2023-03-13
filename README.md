# kotlin-blackjack

## 2단계 기능목록

### 리팩터링
- [ ] 파라미터 수 줄이기

### 도메인 로직 - 베팅

- [x] 게임이 시작하면 플레이어들은 베팅 금액을 설정한다.
- [x] 처음 두장의 합이 21인 경우는 BlackJack이라고 한다.
- [x] 카드의 합이 21을 초과하면 베팅 금액을 잃는다.
- [x] 블랙잭(처음 두장의 합이 21)이면 딜러로부터 베팅금액의 1.5을 받는다.
- [x] 플레이어와 딜러 모두 블랙잭인 경우 플레이어는 베팅금액을 돌려받는다.
- [x] 플레이어가 승리하는 경우 1.0배를 얻는다.
- [x] 플레이어가 패배하는 경우 베팅 금액을 잃는다.

### 입출력

- [x] 각 플레이어들에게 베팅 금액을 입력 받는다.
- [x] 딜러와 플레이어들의 최종수익을 출력한다.

<br>

## 1단계 기능목록

### InputView
- [x] 게임에 참여할 플레이어들의 이름을 입력받는다.(쉼표 기준으로 분리)
  - 검증 어디에서 할건지?

### Card

### Cards
- [x] 승부를 결정할때는 21이 넘지않으면서 가장 가까운 합을 얻을 수 있도록 Ace를 1 또는 11로 계산
- [x] 게임이 시작하면 카드를 두장씩 받는다.
- [x] 카드의 합계가 특정 숫자를 넘는 것을 판단할 수 있다.
- [x] 카드의 합을 알 수 있다.

### GameResult
- [x] 두명의 점수를 비교하여 승패를 결정한다.

### BlackJackReferee
- [x] 최종 승패를 결정한다.

### Player
- [x] 플레이어는 들고있는 카드의 총합이 21이하라면 카드를 추가로 받을 수 있다.
- [x] 더 뽑을거냐고 물어볼때는 Ace 무조건 1로 계산

### Dealer
- [x] 딜러는 들고있는 카드의 총합이 16이하라면 카드를 추가로 받는다.
