package info.bitrich.xchangestream.binance.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.knowm.xchange.binance.dto.marketdata.BinanceKline;

public class KlineBinanceWebsocketTransaction extends ProductBinanceWebSocketTransaction {

    private final BinanceWebsocketKline kline;

    public KlineBinanceWebsocketTransaction(
            @JsonProperty("e") String eventType,
            @JsonProperty("E") String eventTime,
            @JsonProperty("s") String symbol,
            @JsonProperty("k") BinanceWebsocketKline binanceWebsocketKline) {

        super(eventType, eventTime, symbol);

        kline = binanceWebsocketKline;
    }

    public BinanceKline getKline() {
        return kline.toBinanceKline();
    }
}
