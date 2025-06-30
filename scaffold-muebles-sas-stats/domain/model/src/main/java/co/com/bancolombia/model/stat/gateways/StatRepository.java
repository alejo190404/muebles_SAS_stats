package co.com.bancolombia.model.stat.gateways;

import java.util.List;

import co.com.bancolombia.model.stat.Stat;
import reactor.core.publisher.Mono;

public interface StatRepository {
    public Mono<List<Stat>> getEntityBySomeKeys(String partitionKey, String sortKey);
    public Mono<List<Stat>> getEntityBySomeKeysByIndex(String partitionKey, String sortKey);
    public Mono<Stat> save(Stat stat);
}
