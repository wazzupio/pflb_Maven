package ru.pflb.school5.javaOOP;

import java.util.ArrayList;

import ru.pflb.mq.dummy.exception.DummyException;
import ru.pflb.mq.dummy.implementation.ConnectionImpl;
import ru.pflb.mq.dummy.interfaces.Destination;
import ru.pflb.mq.dummy.interfaces.Producer;
import ru.pflb.mq.dummy.interfaces.Session;

public class Main {
    public static void main(String[] args) throws InterruptedException, DummyException {
        ArrayList<String> messages = new ArrayList<>();
        messages.add("Четыре");
        messages.add("Пять");
        messages.add("Шесть");

        String hw_queueName = "myQueue";

        ConnectionImpl hw_connect = new ConnectionImpl();
        hw_connect.start();
        hw_connect.createSession(true);
        Session hw_session = hw_connect.createSession(true);
        Destination hw_destination = hw_session.createDestination(hw_queueName);
        Producer hw_producer = hw_session.createProducer(hw_destination);
        for (String message : messages) {
            Thread.sleep(2000);
            hw_producer.send(message);
        }
        hw_session.close();
        hw_connect.close();
    }
}