# 질문 삭제하기

## step 1. 질문 삭제하기

### 기능 요구사항

- [x] 질문 데이터 삭제하기
    - [x] 질문 데이터를 진짜로 삭제하는 것이 아니라, 적재 상태를 바꾼다.
    - [x] 로그인한 사용자와 질문자가 같은 경우, 삭제가 가능하다.
    - [x] 답변이 없는 경우 삭제가 가능하다.
    - [x] 답변이 있는 경우
        - [x] 모든 답변자가 질문자와 같으면 삭제가 가능하다.
    - [x] 질문을 삭제할 때, 답변도 상태로 바뀌어야 한다.
    - [x] 질문을 삭제할 때, 이력에 대한 정보를 `Deletehistory` 를 통해서 남긴다.

### 프로그래밍 요구사항

`qna.service.QnaService` 의 `deleteQuestion()`는 앞의 질문 삭제 기능을 구현한 코드이다.

이 메소드는 단위 테스트하기 어려운 코드와 단위 테스트 가능한 코드가 섞여 있다.

단위 테스트하기 어려운 코드와 단위 테스트 가능한 코드를 분리해 단위 테스트 가능한 코드 에 대해 단위 테스트를 구현한다.

## step 2 ~ 4. 볼링 게임 점수판

### 기능 요구사항

- [x] 플레이어의 이름을 입력 받는다.
- [x] 플레아어의 이름 글자 수는 3 이어야 한다.


- [ ] 볼링 게임 시작 전 투구 현황판을 출력한다.


- [ ] 볼링 게임
    - [x] 각 투구마다 넘긴 핀의 수를 입력받는다.
    - [ ] 한 번의 투구마다 투구 현황판을 출력한다.
        - 스트라이크 : `X`
        - 스페어 : `/`
        - 점수 : 넘어뜨린 핀 수
        - 거터 : `-`
    - [x] 모든 프레임이 종료될 때 까지 게임을 진행한다.

- [x] 프레임
    - 가능한 상태
        - [x] Initialized
            - 투구한 점수가 10 보다 작으면 Remain
            - 투구한 점수가 10 이면 Strike
            - 진행 상태
        - [x] Remain
            - 이전 투구와 합계가 10 보다 작으면 Open
            - 이전 투구와 합계가 10 이면 Spare
            - 진행 상태
        - [x] Open
            - 첫 번쟤 시도와 두 번째 시도의 합이 10 이 되지 않음
            - 종료 상태
        - [x] Spare
            - 첫 번쟤 시도와 두 번째 시도의 합이 10
            - 종료 상태
        - [x] Strike
            - 첫 번쟤 시도가 10 인 상태
            - 종료 상태