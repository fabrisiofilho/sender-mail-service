package br.com.bluty.senderservice.messenger.constant;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

public class Constants {

    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    public final class Exchange {
        public static final String EXCHANGE = "guideme.exchange";

    }

    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    public final class Queues {

        public static final String QUEUE_MESSENGER = "guideme.messenger.queue";

    }

    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    public final class RoutingKey {

        public static final String KEY_MESSENGER = "KEYMESSENGER";

    }

}
