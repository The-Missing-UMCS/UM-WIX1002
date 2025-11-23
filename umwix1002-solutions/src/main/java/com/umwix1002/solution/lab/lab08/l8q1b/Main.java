package com.umwix1002.solution.lab.lab08.l8q1b;


public class Main {

    public static void main(String[] args) {
        NumberPresenter presenter = new NumberPresenter();

        presenter.displayAll(new Number().getNumbers());
        presenter.displayAll(new Number(5).getNumbers());
        presenter.displayAll(new Number(4, 50).getNumbers());
    }
}
