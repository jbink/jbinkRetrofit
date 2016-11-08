package jbink.appnapps.jbinkretrofit.data;

import java.util.List;

/**
 * Created by user on 2016-09-30.
 */
public class QuestionData {

    /**
     * success : 1
     * message : QUESTION LIST
     * list : [{"idx":"789","question":"비투비 육성재와 고등학교 동창인 멤버는?","answer":"혁"},
     * {"idx":"1230","question":"빅뱅의 멤버 중 불치판명을 받을정도로 다크서클이 심해 판다라는 별명을 갖고있는 멤버는?","answer":"승리"},
     * {"idx":"142","question":"수호가 태어난곳은?","answer":"서울"},{"idx":"1018","question":"신우가 키우는 강아지 이름은?","answer":"곤이"},
     * {"idx":"611","question":"방탄소년단중 춤을 진과 함께 정말잘못추는맴버는?","answer":"랩몬스터"},{"idx":"79","question":"세훈이 좋아하는 음료는?","answer":"버블티"},
     * {"idx":"1074","question":"인피니트의 리더는?","answer":"김성규"},{"idx":"755","question":"빅스 멤버중 혈액형이 B형인 멤버는?","answer":"홍빈"},
     * {"idx":"562","question":"방탄소년단 지민 동생의 이름은?","answer":"박지현"},{"idx":"61","question":"EXO 내에서 가장 전자제품을 잘 고치는 멤버는?","answer":"찬열"}]
     */

    private int success;
    private String message;
    /**
     * idx : 789
     * question : 비투비 육성재와 고등학교 동창인 멤버는?
     * answer : 혁
     */

    private List<ListBean> list;

    public int getSuccess() {
        return success;
    }

    public void setSuccess(int success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<ListBean> getList() {
        return list;
    }

    public void setList(List<ListBean> list) {
        this.list = list;
    }

    public static class ListBean {
        private String idx;
        private String question;
        private String answer;

        public String getIdx() {
            return idx;
        }

        public void setIdx(String idx) {
            this.idx = idx;
        }

        public String getQuestion() {
            return question;
        }

        public void setQuestion(String question) {
            this.question = question;
        }

        public String getAnswer() {
            return answer;
        }

        public void setAnswer(String answer) {
            this.answer = answer;
        }
    }
}
