package co.com.bancolombia.usecase.processstats;

import co.com.bancolombia.model.stat.Stat;
import lombok.RequiredArgsConstructor;
@RequiredArgsConstructor
public class ProcessStatsUseCase {
    public String exposeEndpointTest(){
        return "Endpdoint exposed appropiately";
    }

    public boolean processStats(Stat stat){
        //Logic to process the stats accordingly to requirements
        return true; //Hardcoded
    }
}
