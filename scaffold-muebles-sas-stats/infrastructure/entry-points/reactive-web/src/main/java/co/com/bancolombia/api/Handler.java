package co.com.bancolombia.api;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import co.com.bancolombia.model.stat.Stat;
import co.com.bancolombia.usecase.processstats.ProcessStatsUseCase;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class Handler {
//private  final UseCase useCase;
private final ProcessStatsUseCase proccessStatsUseCase;
//private  final UseCase2 useCase2;

    public Mono<ServerResponse> listenPOSTProcessStats(ServerRequest serverRequest) {
        return serverRequest
                .bodyToMono(Stat.class)
                .map(stat -> proccessStatsUseCase.processStats(stat))
                .flatMap(result -> ServerResponse.ok().bodyValue(result));
    }
}
