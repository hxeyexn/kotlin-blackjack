# kotlin-blackjack

## 입력
- [x] 게임에 참여할 사람의 이름들을 입력받는다.
- [x] 플레이어별로 카드를 더 받을지 입력받는다.


## 출력
- [x] 나누어 준 카드를 출력한다.
- [x] 추가로 뽑은 카드를 포함하여 출력한다.
- [x] 딜러가 추가로 뽑았는지에 대한 여부를 출력한다.
- [x] 참가자들의 카드와 결과 값을 출력한다.
- [x] 최종 승패를 출력한다.

## 기능리스트
- [x] 카드를 세팅한다.
- [x] 덱에서 카드를 뽑아준다.
- [x] 딜러와 플레이어들에게 카드를 2장씩 나누어준다.
- [x] 딜러의 카드를 뽑는다.
- [x] 플레이어의 카드를 뽑는다.
- [x] 카드의 문자에 따라 값을 리턴한다.
- [x] 카드를 셔플한다.
- [x] 플레이어별로 추가로 카드를 뽑는다.
  - [x] 플레이어가 카드를 뽑는다.
    - [x] 카드의 합산이 21을 초과하는지 검사한다.
    - [x] A가 이미 하나있을 때 11 -> 1로 반환
    - [x] 합이 10초과일 때 11 -> 1로 반환
- [x] 딜러의 카드 결과값에 16이 넘는지 판별한다. : Boolean
  - [x] 16이하이면 카드를 추가로 뽑는다.
- [x] 카드값의 합산을 구한다.
- [x] 플레이어 승부를 가져와서 딜러의 승패를 계산한다
  - [x] 승부를 뒤집는다.(승 -> 패, 패 -> 승)
- [x] 모든 플레이어의 승패를 계산한다. 

## 에외상황
- [x] 입력이 y나 n이 아닌경우
- [ ] 총 참여인원은 8명으로 제한한다.
