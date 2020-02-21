package test;

import test.api.Answers;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Question {
    private int id;
    private StringBuilder qData = new StringBuilder();//текст вопроса
    private List<Answers> listOfAnswers = new ArrayList<>(2);//лист верных ответов
    Random rand = new Random();//нужно для выбора вопроса

    public Question() {
        String answer2;
        try {
            BufferedReader reader = new BufferedReader(new FileReader("src\\test\\questions\\Question_" + (id = (rand.nextInt(9) + 1)) + ".txt"));//читает случайный файл из папки test.questions
            String str = reader.readLine();
            while (str != null) {//цикл записывает текст из файла в поле qData
                if (str.matches("CorrectAnswer([A|B|C|D])+")) {//в последней строчке файла записан верный ответ в формате CorrectAnswerВЕРНЫЙ_ОТВЕТ, если
                    // такой паттерн обнаруживается, то выделяется подстрока с буквой/буквами верного ответа и записывается в поле "Лист правильных ответов" и цикл прерывается
                    answer2 = str.substring(13);
                    if (answer2.length() > 1) {//если ответов больше 1, то подстрока разбивается на символы и каждый символ законяется в поле Лист правильных ответов
                        char[] charArray = answer2.toCharArray();
                        for (char a : charArray) {
                            listOfAnswers.add(Answers.valueOf(String.valueOf(a)));
                        }
                    } else {//если ответ один, то он просто добавляется в поле "Лист правильных ответов"
                        listOfAnswers.add(Answers.valueOf(answer2));
                    }
                    break;
                }//if
                this.qData.append(str + "\n");
                str = reader.readLine();
            }
        } catch (FileNotFoundException e) {
            System.out.println("Отсутствует файл");
            return;
        } catch (IOException e) {
            System.out.println("Ошибка ввода-вывода");
            return;
        }
       /* System.out.println("ID вопроса " + id); //это для теста вопроса
        System.out.println(this.qData);
        System.out.println("Правильные ответы " + listOfAnswers.toString());*/

    }

//изменение нужного вопроса, новые данные записываются в вопрос с номером Id(порядковый номер в папке вопросы). Ответы записывают последней строкой в файл.
    public void changeQuestion(String newQData, String answers) {
        File file1 = new File("src\\test\\questions\\Question_" + this.id + ".txt");
            try (PrintWriter bWriter = new PrintWriter(new FileWriter(file1))) {
                bWriter.write(newQData);
                bWriter.write("\nCorrectAnswer" + answers);

            } catch (IOException e) {
                e.printStackTrace();
            }

    }
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || !(obj instanceof Question)) return false;
        Question quest = (Question) obj;
        return (this.id == quest.id && this.qData.toString().equals(quest.qData.toString()));
    }

    public int hashCode() {
        return this.id * 2 + 3 * this.qData.length();
    }

    public String toString() {
        return "Вопрос № " + this.id + " ";
    }

    //геттеры/сеттеры
    public int getId() {
        return this.id;
    }

    public StringBuilder getqData() {
        return qData;
    }

    public List<Answers> getListOfAnswers() {
        return listOfAnswers;
    }


}