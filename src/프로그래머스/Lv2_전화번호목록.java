package 프로그래머스;

import java.util.*;

public class Lv2_전화번호목록 {
    public boolean solution(String[] phone_book) {
        PhoneBook phoneBook = new PhoneBook(phone_book);
        return phoneBook.isCheck();
    }
}

class PhoneBook {
    private final Set<String> checkNumber = new HashSet<>();
    private final String[] number;

    public PhoneBook(String[] number) {
        this.number = number;
    }

    public boolean isCheck() {
        addAll();

        for (String s : this.number) {
            for (int i = 1; i < s.length(); i++) {
                if (this.checkNumber.contains(s.substring(0, i))) {
                    return false;
                }
            }
        }

        return true;
    }

    private void addAll() {
        for (String s : this.number) {
            this.checkNumber.add(s);
        }
    }
}

