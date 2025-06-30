package co.com.bancolombia.usecase.processstats;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import co.com.bancolombia.model.stat.Stat;
import co.com.bancolombia.model.stat.gateways.StatRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ProcessStatsUseCase {

    private final StatRepository statRepository;

    public String exposeEndpointTest() {
        return "Endpdoint exposed appropiately";
    }

    public String processStats(Stat stat) {
        // if hash is correct, add it to DB and publish it to rabbitMQ
        boolean isHashValid = true; // hardcoded for tests
        if (isHashValid) {
            // Set stat timestamp
            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
            stat.setTimestamp(now.format(formatter));
            
            try {
                // DynamoDB. Add with primary key as timestamp
                statRepository.save(stat);
            } catch (Exception e) {
                System.out.println(e);
                return "Could not save stat into the DB";
            }

            // RabbitMQ. Add it to queue "event.stats.validated"
            try {
                // Logic for publishing
                
            } catch (Exception e) {
                System.out.println(e);
                return "Could not publish stat into the queue";
            }

            return "Successfull opeartion";
        }

        // if hash is not correct, return 400 and error message
        return "Invalid hash";
    }
}
