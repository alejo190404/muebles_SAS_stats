package co.com.bancolombia.usecase.processstats;

import co.com.bancolombia.model.stat.Stat;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ProcessStatsUseCase {

    public String exposeEndpointTest() {
        return "Endpdoint exposed appropiately";
    }

    public boolean processStats(Stat stat) {
        // if hash is correct, add it to DB and publish it to rabbitMQ
        if (true){
            // DynamoDB. Add with primary key as timestamp
            

            // RabbitMQ. Add it to queue "event.stats.validated"

        }
        
        // if hash is not correct, return 400 and error message
        return false;
    }
}
