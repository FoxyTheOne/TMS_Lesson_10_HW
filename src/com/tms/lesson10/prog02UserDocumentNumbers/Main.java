package com.tms.lesson10.prog02UserDocumentNumbers;

import java.io.*;
import java.util.*;

/**
 *  2. Программа должна получать имена файлов с номерами документов с консоли: каждая новая строка - это путь к файлу и имя файла.
 * 	Для завершения ввода списка файлов следует ввести 0.
 *
 * 	После получения списка документов программа должна обработать каждый документ: вычитать из файла номера документов и провалидировать их.
 * 	В конце работы создать один файл отчет с выходной информаций: номер документа - комментарий(валиден или не валиден и по какой причине).
 *
 * 	Пусть каждый файл содержит каждый номер документа с новой строки и в строке никакой другой информации, только номер документа.
 * 	Валидный номер документа должен иметь длину 15 символов и
 * 	начинаться с последовательности docnum(далее любая последовательность букв/цифр) или kontract(далее любая последовательность букв/цифр).
 *
 * 	Учесть, что номера документов могут повторяться в пределах одного файла и так же разные документы могут содержать одни и те же номера документов.
 * 	Если номера документов повторяются, то повторные номера документов не проверять, не валидировать.
 *
 * 	Немного технических деталей
 * 	- Считать с консоли список документов: раз список - то это коллекции типа List, никаких других условий нет - значит все имена файлов с консоли сохраняем в структуру данных ArrayList.
 * 	- Номера документов могут повторяться, но повторыне документы обрабатывать не надо и валидировать не надо,т.е. по сути дубликаты нам не нужны - значит, надо считать номера документов из файлов и все номера документов сохнанять в коллекцию типа Set. Других условий нет, значит можно использовать HashSet.
 * 	- В конце должна быть структура номер документа - комментарий - т.е. эта структура типа ключ-значений,значит это коллекция типа Map.
 * 	Других условий нет - значит, можно использовать HashMap. Создать такую структуру и уже потом сделать цикл по этой структуре и записать всю информацию из этой мапы в файл-отчет.
 */
public class Main {
    public static void main(String[] args) {
        ArrayList<String> pathToFileArray = new ArrayList<>(); // Коллекция, куда далее будут записываться введенные пути к файлам

        Scanner sc = new Scanner(System.in);
        System.out.print("Введите путь к файлу с номерами документов, включая имя файла: ");

        String stop = "0";
        while (sc.hasNext()) {
            String str = sc.nextLine();
            if (str.equals(stop)) {
                break;
            } else {
                System.out.println();
                System.out.println("Для завершения ввода списка файлов введите 0.");
                System.out.print("Введите путь к файлу с номерами документов, включая имя файла: ");
            }
            pathToFileArray.add(str); // Добавляем строку в коллекцию
        }
        System.out.println("Ввод списка файлов завершён.");
        System.out.println();
        System.out.println("Идёт обработка...");
        System.out.println();

        String pathForFinalReport = "C:\\java\\TeachMeSkills\\TMS_Lesson_10_HW\\FinalReport.txt";

        HashSet<String> docNumbersHashSet = new HashSet<>(); // Коллекция, куда далее запишутся все номера документов из всех файлов, чтобы избежать дублирования номеров
        HashMap<String, String> docNumberWithCommentHashMap = new HashMap<>(); // Коллекция типа Map, куда после всех обработок запишем "номер документа - комментарий" для последующей записи в файл

        for (String itemPath: pathToFileArray) { // Каждый цикл перебираем по одному введённому пути к файлу
            try (BufferedReader fr = new BufferedReader(new FileReader(itemPath));
                 PrintWriter fwReport = new PrintWriter(new BufferedWriter(new FileWriter(pathForFinalReport)))) {

                String docNumbers;
                while ((docNumbers = fr.readLine()) != null) { // Каждый цикл считываем одну строку, пока не закончится документ, и записываем в docNumbersHashSet
                    docNumbersHashSet.add(docNumbers);
                }

                // Мы записали в docNumbersHashSet все номера документов. Теперь нужно их проверить на валидность:
                for (String itemDoc : docNumbersHashSet) {
                    String docNumberComment = checkDocNumberReturnComment(itemDoc); // В методе формулируем полный комментарий для записи в файл
                    docNumberWithCommentHashMap.put(itemDoc, docNumberComment); // Записываем номер документа и комментарий в HashMap
                }

                // Мы записали в docNumberWithCommentHashMap все номера документов с комментариями. Теперь запишем всё это в файл-отчет
                // For-each для HashMap:
                for (Map.Entry<String, String> item : docNumberWithCommentHashMap.entrySet()) {
                    String docFinalReport = item.getKey() + " - " + item.getValue();
                    fwReport.println(docFinalReport);
                    fwReport.println();
                }
            } catch (FileNotFoundException e1) {
                System.out.println();
                System.out.println("Файл не найден. Проверьте путь к файлу");
                System.out.println(e1);
            } catch (IOException e2) {
                System.out.println();
                System.out.println(e2);
                e2.printStackTrace();
            }
        }
        System.out.println("Обработка завершена.");
        System.out.println("Проверенные номера документов записаны в файл " + pathForFinalReport);
    }

    public static String checkDocNumberReturnComment(String docNumber) {
        StringBuilder commentBuilder = new StringBuilder();

        boolean check1 = DocumentCheck.numberLength15(docNumber);
        boolean check2 = DocumentCheck.onlyNumAndLetter(docNumber);
        boolean check3 = DocumentCheck.beginsWithDocnumOrKontract(docNumber);

        if (check1 && check2 && check3) {
            commentBuilder.append("Валидный номер документа.");
        } else {
            commentBuilder.append("Невалидный номер документа.");
            if (!check1) {
                commentBuilder.append(" Длина не 15 символов.");
            }
            if (!check2) {
                commentBuilder.append(" Номер документа содержит служебные символы.");
            }
            if (!check3) {
                commentBuilder.append(" Номер документа не начинается с docnum или kontract.");
            }
        }

        String comment = String.valueOf(commentBuilder);
        return comment;
    }
}
