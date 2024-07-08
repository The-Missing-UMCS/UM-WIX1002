package Lab10.L10Q4;

public class Main {
    public static void main(String[] args) {
        Repository repo = new IORepository();
        Presenter presenter = new Presenter(repo);
        
        repo.makeAppointment(2022, 12, 16, 17, 19);
        repo.makeAppointment(2022, 12, 16, 12, 13);
        repo.makeAppointment(2022, 12, 17, 12, 13);
        repo.makeAppointment(2022, 12, 16, 11, 12);
        repo.makeAppointment(2022, 12, 16, 16, 18);
        repo.makeAppointment(2023, 1, 1, 11, 12);
        repo.doneAppointment(2);

        presenter.present();
    }

}
