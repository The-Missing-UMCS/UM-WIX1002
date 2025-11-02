package com.umwix1002.solution.lab.lab10.l10q4b;

public class Main {

    public static void main(String[] args) {
        Repository repository = new Repository();
        Presenter presenter = new Presenter();

        repository.makeAppointment(2022, 12, 16, 17, 19);
        repository.makeAppointment(2022, 12, 16, 12, 13);
        repository.makeAppointment(2022, 12, 17, 12, 13);
        repository.makeAppointment(2022, 12, 16, 11, 12);
        repository.makeAppointment(2022, 12, 16, 16, 18);
        repository.makeAppointment(2023, 1, 1, 11, 12);
        repository.doneAppointment(2);

        presenter.present(repository.getAppointments());
    }

}
