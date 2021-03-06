// Copyright © 2012-2018 Vaughn Vernon. All rights reserved.
//
// This Source Code Form is subject to the terms of the
// Mozilla Public License, v. 2.0. If a copy of the MPL
// was not distributed with this file, You can obtain
// one at https://mozilla.org/MPL/2.0/.

package io.vlingo.reactive.messaging.patterns.publishsubscribe;

import io.vlingo.actors.Actor;
import io.vlingo.actors.pubsub.Message;
import io.vlingo.actors.pubsub.Subscriber;

public class NASDAQSubscriber extends Actor implements Subscriber<PriceQuoted> {

    private final MarketQuotationResults results;

    public NASDAQSubscriber(final MarketQuotationResults results) {
        this.results = results;
    }
    
    /* @see io.vlingo.actors.pubsub.Subscriber#receive(io.vlingo.actors.pubsub.Message) */
    @Override
    public void receive(final Message message) {
        logger().log("NASDAQSubscriber received " + message);
        results.access.writeUsing("afterQuotationReceivedAtNASDAQSubscriberCount", 1);
    }
}