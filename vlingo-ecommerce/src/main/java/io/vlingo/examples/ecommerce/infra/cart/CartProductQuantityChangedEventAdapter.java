package io.vlingo.examples.ecommerce.infra.cart;

import io.vlingo.common.serialization.JsonSerialization;
import io.vlingo.examples.ecommerce.model.CartEvents;
import io.vlingo.examples.ecommerce.model.CartEvents.ProductQuantityChangeEvent;
import io.vlingo.symbio.BaseEntry;
import io.vlingo.symbio.BaseEntry.TextEntry;
import io.vlingo.symbio.EntryAdapter;
import io.vlingo.symbio.Metadata;

public class CartProductQuantityChangedEventAdapter implements EntryAdapter<CartEvents.ProductQuantityChangeEvent,BaseEntry.TextEntry> {

    @Override
    public CartEvents.ProductQuantityChangeEvent fromEntry(final BaseEntry.TextEntry entry) {
        return JsonSerialization.deserialized(entry.entryData(), CartEvents.ProductQuantityChangeEvent.class);
    }

    @Override
    public BaseEntry.TextEntry toEntry(final CartEvents.ProductQuantityChangeEvent source) {
      return toEntry(source, source.cartId);
    }

    @Override
    public TextEntry toEntry(ProductQuantityChangeEvent source, String id) {
        final String serialization = JsonSerialization.serialized(source);
        return new BaseEntry.TextEntry(id, CartEvents.ProductQuantityChangeEvent.class, 1, serialization, Metadata.nullMetadata());
    }
}
