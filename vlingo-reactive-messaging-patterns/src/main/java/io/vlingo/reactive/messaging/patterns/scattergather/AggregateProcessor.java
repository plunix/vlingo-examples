// Copyright © 2012-2018 Vaughn Vernon. All rights reserved.
//
// This Source Code Form is subject to the terms of the
// Mozilla Public License, v. 2.0. If a copy of the MPL
// was not distributed with this file, You can obtain
// one at https://mozilla.org/MPL/2.0/.
package io.vlingo.reactive.messaging.patterns.scattergather;

import io.vlingo.reactive.messaging.patterns.scattergather.BestPriceQuotation.PriceQuote;
import io.vlingo.reactive.messaging.patterns.scattergather.BestPriceQuotation.PriceQuoteTimedOut;

/**
 * AggregateProcessor
 *
 * @author brsg.io
 * @since Nov 21, 2018
 */
public interface AggregateProcessor
{
    void requiredPriceQuoteForFulfillment( String rfqId, Integer quotesRequested, OrderProcessor orderProcessor );
    void priceQuoteFulfilled( PriceQuote priceQuote );
    void priceQuoteTimedOut( PriceQuoteTimedOut priceQuoteTimedOut );
}