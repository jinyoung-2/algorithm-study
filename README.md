# A/S 알고리즘 스터디

2022 1학기 동안 진행

<br>

## 문제집

<details><summary><strong>주차별 과제</strong></summary>


|       | 안치산 | 이진영 | 최문형 |
| ----- | ------ | ------ | ------ |
| 1주차 |        |        |        |
| 2주차 |        |        |        |
| 3주차 |        |        |        |
| 4주차 |        |        |        |
| 5주차 |        |        |        |
|       |        |        |        |
|       |        |        |        |
|       |        |        |        |
|       |        |        |        |

</details>

<details><summary><strong>주차별 개념 + 관련 문제</strong></summary>


|       | 발표할 개념 | 발표자 | 문제 1 | 문제 2 |
| ----- | ----------- | ------ | ------ | ------ |
| 1주차 |             |        |        |        |
| 2주차 |             |        |        |        |
| 3주차 |             |        |        |        |
| 4주차 |             |        |        |        |
| 5주차 |             |        |        |        |
|       |             |        |        |        |
|       |             |        |        |        |
|       |             |        |        |        |
|       |             |        |        |        |

</details>

<br><br>

## 스터디 진행 방식

* ### 개념 스터디

  * 스터디 당일 (토요일 9시)
  * 주차별로 돌아가면서 원하는 개념 발표 + 관련 문제 2개 정해오기
  * 진행방식
    1. 개념 발표
    2. 해당 개념에 대해서 질의응답 등 자유롭게 토의
    3. 관련 문제 다같이 풀어보고 풀이 공유

  <br>

* ### 과제 (2문제)

  * 진행방식
    1. **공동 2문제 풀어보기 + 코드 리뷰**
       * 토요일까지 문제 골라서 issue랑 README 표에 추가
       * 과제 제출 방식 참고
    2. 자유롭게 2문제씩 풀어오기 + 인당 한문제씩 코드리뷰

<br><br>

## 과제 제출 방식

### 0. 초기 환경 설정

맨 처음, 이 repository를 `fork` 해온 뒤 자신의 이름으로 된 폴더 생성하기.

> 앞으로 올리는 모든 파일들은 `자신의 이름` 폴더에 올린다.

<br>


### 1. 저장소 최신으로 업데이트

커밋 내역을 깔끔하게 하기 위해서 `-r` 옵션 사용

```bash
$ git pull -r upstream main
```

<br>

### 2. 문제별로 커밋 생성

* 문제별 고민 시간은 최대 1시간을 넘기지 않는 것이 좋다.

* 코드 리뷰를 진행하므로 최대한 가독성이 좋게 작성하려고 노력해보자

* 커밋하는 방법

  ```bash
  $ git add .
  $ git status
  $ git commit -m "#10 - [프로그래머스] 문자열 압축 / 30분"
  $ git push origin main
  ```

* **커밋 메시지 생성 규칙**

  `#문제집issue번호 - [문제출처] 문제이름 / 소요시간 (풀지못한 경우 실패)`

  ex) #10 - [프로그래머스] 문자열 압축 / 30분

  > 커밋 메시지에 issue 번호를 포함시키면, 추후에 issue에 해당 커밋들을 모아서 확인할 수 있다.

<br>

### 3. 해당 주차의 문제들을 다 풀고나면 PR 생성

`fork` 해 온 저장소로 이동해서 Pull Request를 생성한다.

* **제목**: 제목에 `문제집 이슈번호`와 `작성자`를 포함시켜서 작성<br>ex) `#10 알고리즘 문제풀이 - chisan01`

* **내용**: 풀이 간단하게 설명, 문제풀면서 어려웠던 점, 소요시간 등 적어두기

- reviewer 모두 지정

<br>

### 4. 코드리뷰 후 merge

* 코드 리뷰 내용은 자유롭게 작성하기
  - 코드에 대해서 궁금한 점 질문
  - 코드에 대한 칭찬
  - 코드 개선 아이디어 건의 (성능, 클린코드 등)
  - 등등 ..
* 코드 리뷰가 끝난 뒤 필요에 따라 추가로 리팩토링하고 커밋 (커밋 형식은 자유)

<br>
