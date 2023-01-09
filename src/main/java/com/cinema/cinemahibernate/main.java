package com.cinema.cinemahibernate;

// import com.sun.tools.jdeprscan.scan.Scan;
import jakarta.persistence.*;

        import java.sql.*;
import java.util.Scanner;

public class main {

    private static String name;
    private static String surname;

    private static String title;
    private static String director_n;
    private static String director_s;
    private static int duration;

    private static String timestamp_d;
    private static String timestamp_h;
    private static int mov_id;
    private static int opt;
    private static int cust_id;
    int[][] auditorium = new int[10][10];
    int[] seat_id = new int[100];
    private static String results;
    private static int tick_id;

    public static void main(String[] args) throws SQLException {
        while(true) {
            EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
            EntityManager entityManager = entityManagerFactory.createEntityManager();
            EntityTransaction transaction = entityManager.getTransaction();
            Scanner scanner = new Scanner(System.in);

            try {
                transaction.begin();
                Screening scr1 = new Screening();
                Movies mov1 = new Movies();
                Customer cust1 = new Customer();
                Ticket tick1 = new Ticket();

                System.out.println("What do you want to do?:");
                System.out.println("0. Close session.");
                System.out.println("1. Create new user.");
                System.out.println("2. Create new movie.");
                System.out.println("3. Create new screening.");
                System.out.println("4. Create new ticket.");
                System.out.println("5. Show tickets.");
                System.out.println("6. Delete ID from Tickets.");
                opt = scanner.nextInt();
                if (opt == 1) {
                    cust1.setId(0);
                    System.out.println("[NEW] Enter customer's data.");
                    System.out.println("\tName: ");
                    name = scanner.next();
                    cust1.setName(name);
                    System.out.println("\tSurname: ");
                    surname = scanner.next();
                    cust1.setSurname(surname);
                    entityManager.merge(cust1);
                    System.out.println("Customer " + cust1.getSurname() + ", " + cust1.getName() + ": created.");
                } else if (opt == 2) {
                    mov1.setId(0);
                    System.out.println("[NEW] Enter movie's data.");
                    System.out.println("\tTitle: ");
                    title = scanner.next();
                    mov1.setTitle(title);
                    System.out.println("\tDirector:");
                    director_n = scanner.next();
                    director_s = scanner.next();
                    mov1.setDirector(director_n + " " + director_s);
                    System.out.println("\tDuration:");
                    duration = scanner.nextInt();
                    mov1.setDuration(duration);
                    entityManager.merge(mov1);
                    System.out.println("Movie " + mov1.getTitle() + ", " + mov1.getDirector() + ": created.");
                } else if (opt == 3) {
                    scr1.setId(0);
                    System.out.println("[NEW] Enter screening's data.");
                    System.out.println("\tMovie_ID: ");
                    mov_id = scanner.nextInt();
                    scr1.setMovieId(mov_id);
                    System.out.println("\tScreening's date and hour [f: 'YYYY-MM-DD HH:MM:SS']:");
                    timestamp_d = scanner.next();
                    timestamp_h = scanner.next();
                    scr1.setDateTime(Timestamp.valueOf(timestamp_d + " " + timestamp_h));
                    System.out.println("Screening " + scr1.getMovieId() + ", " + scr1.getDateTime() + ": created.");
                    entityManager.merge(scr1);
                } else if (opt == 4) {
                    tick1.setId(0);
                    System.out.println("[NEW] Enter ticket's data.");
                    System.out.println("\tCustomer's ID:");
                    cust_id = scanner.nextInt();
                    tick1.setClientId(cust_id);
                    System.out.println("\tMovie's ID:");
                    mov_id = scanner.nextInt();
                    tick1.setMovieId(mov_id);
                    System.out.println("\tSeat ID:");
                    System.out.println("Work in progress: seat's ID set to 1 by default.");
                    tick1.setSeatId(1);
                    System.out.println("Ticket " + tick1.getClientId() + ", " + tick1.getMovieId() + ", " + tick1.getSeatId() + ": created.");
                    entityManager.merge(tick1);
                } else if (opt == 0) {
                    System.out.println("Closing session.");
                    return;
                } else if (opt == 5) {
                    String h_id = "select title from Movies";
                    Query query = entityManager.createQuery(h_id);
                    System.out.println(query.getResultList());
                } else if (opt == 6) {
                    System.out.println("Provide data to delete.");
                    String hql = "DELETE FROM Ticket WHERE id = :ObID";
                    Query query = entityManager.createQuery(hql);
                    System.out.println("\tTable name: set to Ticket by default");
                    name = scanner.next();
                    //query.setParameter("Tab", name);
                    System.out.println("\tID:");
                    tick_id = scanner.nextInt();
                    query.setParameter("ObID", tick_id);
                    int result = query.executeUpdate();
                    System.out.println("DELETED! Rows affected: " + result);
                }


                transaction.commit();
            } finally {
                if (transaction.isActive()) {
                    transaction.rollback();
                }
                entityManager.close();
                entityManagerFactory.close();
            }
        }
    }
}