package com.interview.guava.collection;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import lombok.Data;

import java.util.*;

/**
 * @author jason.yang
 * @Description
 * @Date 2021-09-30 10:57
 */
public class MultimapTest {

    Map<String, List<StudentScore>> StudentScoreMap = new HashMap<String, List<StudentScore>>();

    public void testStudentScore() {

        for (int i = 10; i < 20; i++) {
            StudentScore studentScore = new StudentScore();
            studentScore.CourseId = 1001 + i;
            studentScore.score = 100 - i;
            addStudentScore("peida", studentScore);
        }

        System.out.println("StudentScoreMap:" + StudentScoreMap.size());
        System.out.println("StudentScoreMap:" + StudentScoreMap.containsKey("peida"));

        System.out.println("StudentScoreMap:" + StudentScoreMap.containsKey("jerry"));
        System.out.println("StudentScoreMap:" + StudentScoreMap.size());
        System.out.println("StudentScoreMap:" + StudentScoreMap.get("peida").size());

        List<StudentScore> StudentScoreList = StudentScoreMap.get("peida");
        if (StudentScoreList != null && StudentScoreList.size() > 0) {
            for (StudentScore stuScore : StudentScoreList) {
                System.out.println("stuScore one:" + stuScore.CourseId + " score:" + stuScore.score);
            }
        }
    }

    public void addStudentScore(final String stuName, final StudentScore studentScore) {
        List<StudentScore> stuScore = StudentScoreMap.get(stuName);
        if (stuScore == null) {
            stuScore = new ArrayList<StudentScore>();
            StudentScoreMap.put(stuName, stuScore);
        }
        stuScore.add(studentScore);
    }

    public void teststuScoreMultimap() {
        Multimap<String, StudentScore> scoreMultimap = ArrayListMultimap.create();
        for (int i = 10; i < 20; i++) {
            StudentScore studentScore = new StudentScore();
            studentScore.CourseId = 1001 + i;
            studentScore.score = 100 - i;
            scoreMultimap.put("peida", studentScore);
        }
        System.out.println("scoreMultimap:" + scoreMultimap.size());
        System.out.println("scoreMultimap:" + scoreMultimap.keys());

        scoreMultimap.asMap().forEach((name,stuScore) -> {
            stuScore.stream().forEach(studentScore -> {
                System.out.println("学生名称："+ name);
                System.out.println("-->学生分数信息：stuScore one:" + studentScore.CourseId + " score:" + studentScore.score);
            });
        });


        System.out.println("-----------------------------------------------------------------------------------------------");

        Collection<StudentScore> studentScore = scoreMultimap.get("peida");
        StudentScore studentScore1=new StudentScore();
        studentScore1.CourseId=1034;
        studentScore1.score=67;
        studentScore.add(studentScore1);

        StudentScore studentScore2=new StudentScore();
        studentScore2.CourseId=1045;
        studentScore2.score=56;
        scoreMultimap.put("jerry",studentScore2);

        System.out.println("scoreMultimap:"+scoreMultimap.size());
        System.out.println("scoreMultimap:"+scoreMultimap.keys());


        for(StudentScore stuScore : scoreMultimap.values()) {
            System.out.println("stuScore one:"+stuScore.CourseId+" score:"+stuScore.score);
        }

        scoreMultimap.remove("jerry",studentScore2);
        System.out.println("scoreMultimap:"+scoreMultimap.size());
        System.out.println("scoreMultimap:"+scoreMultimap.get("jerry"));

        scoreMultimap.put("harry",studentScore2);
        scoreMultimap.removeAll("harry");
        System.out.println("scoreMultimap:"+scoreMultimap.size());
        System.out.println("scoreMultimap:"+scoreMultimap.get("harry"));

    }


    public static void main(String[] args) {
        MultimapTest multimapTest = new MultimapTest();
        multimapTest.teststuScoreMultimap();
    }

}

class StudentScore {
    int CourseId;
    int score;
}