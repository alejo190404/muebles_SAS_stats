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

    public boolean processStats(Stat stat) {
        // if hash is correct, add it to DB and publish it to rabbitMQ
        if (true) { // hardcoded for tests
            // DynamoDB. Add with primary key as timestamp
            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
            stat.setTimestamp(now.format(formatter));

            statRepository.save(stat);

            // RabbitMQ. Add it to queue "event.stats.validated"

        }

        // if hash is not correct, return 400 and error message
        return false;
    }
}
