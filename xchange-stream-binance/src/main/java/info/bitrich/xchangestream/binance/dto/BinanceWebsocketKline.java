package info.bitrich.xchangestream.binance.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.knowm.xchange.binance.BinanceAdapters;
import org.knowm.xchange.binance.dto.marketdata.BinanceKline;
import org.knowm.xchange.binance.dto.marketdata.KlineInterval;
import org.knowm.xchange.currency.CurrencyPair;

import java.math.BigDecimal;

public final class BinanceWebsocketKline {

    private final long openTime;
    private final long closeTime;
    private final CurrencyPair pair;
    private final KlineInterval interval;
    // private final String symbol;
    // private final String interval;
    private final long openOrderNo;
    private final long closeOrderNo;
    private final BigDecimal open;
    private final BigDecimal close;
    private final BigDecimal high;
    private final BigDecimal low;
    private final BigDecimal volume;
    private final long numberOfTrades;
    private final boolean isClose;
    private final BigDecimal quoteAssetVolume;
    private final BigDecimal takerBuyBaseAssetVolume;
    private final BigDecimal takerBuyQuoteAssetVolume;

    public BinanceWebsocketKline(
            @JsonProperty("t") long openTime,
            @JsonProperty("T") long closeTime,
            @JsonProperty("s") String symbol,
            @JsonProperty("i") String interval,
            @JsonProperty("f") long openOrderNo,
            @JsonProperty("L") long closeOrderNo,
            @JsonProperty("o") BigDecimal open,
            @JsonProperty("c") BigDecimal close,
            @JsonProperty("h") BigDecimal high,
            @JsonProperty("l") BigDecimal low,
            @JsonProperty("v") BigDecimal volume,
            @JsonProperty("n") long numberOfTrades,
            @JsonProperty("x") boolean isClose,
            @JsonProperty("q") BigDecimal quoteAssetVolume,
            @JsonProperty("V") BigDecimal takerBuyBaseAssetVolume,
            @JsonProperty("Q") BigDecimal takerBuyQuoteAssetVolume

    ) {

        this.openTime = openTime;
        this.closeTime = closeTime;
        this.pair = BinanceAdapters.adaptSymbol(symbol);
        KlineInterval value1 = null;
        for (KlineInterval value : KlineInterval.values()) {
            if (value.code().equals(interval)) {
                value1 = value;
                break;
            }
        }
        this.interval = value1;

        this.openOrderNo = openOrderNo;
        this.closeOrderNo = closeOrderNo;
        this.open = open;
        this.close = close;
        this.high = high;
        this.low = low;
        this.volume = volume;
        this.numberOfTrades = numberOfTrades;
        this.isClose = isClose;
        this.quoteAssetVolume = quoteAssetVolume;
        this.takerBuyBaseAssetVolume = takerBuyBaseAssetVolume;
        this.takerBuyQuoteAssetVolume = takerBuyQuoteAssetVolume;

    }


    public long getOpenTime() {
        return openTime;
    }

    public long getCloseTime() {
        return closeTime;
    }

    public CurrencyPair getPair() {
        return pair;
    }

    public KlineInterval getInterval() {
        return interval;
    }

    public long getOpenOrderNo() {
        return openOrderNo;
    }

    public long getCloseOrderNo() {
        return closeOrderNo;
    }

    public BigDecimal getOpen() {
        return open;
    }

    public BigDecimal getClose() {
        return close;
    }

    public BigDecimal getHigh() {
        return high;
    }

    public BigDecimal getLow() {
        return low;
    }

    public BigDecimal getVolume() {
        return volume;
    }

    public long getNumberOfTrades() {
        return numberOfTrades;
    }

    public boolean isClose() {
        return isClose;
    }

    public BigDecimal getQuoteAssetVolume() {
        return quoteAssetVolume;
    }

    public BigDecimal getTakerBuyBaseAssetVolume() {
        return takerBuyBaseAssetVolume;
    }

    public BigDecimal getTakerBuyQuoteAssetVolume() {
        return takerBuyQuoteAssetVolume;
    }

    public BinanceKline toBinanceKline() {
        return new BinanceKline(pair, interval, openTime, open, high, low, close, volume, closeTime, quoteAssetVolume, numberOfTrades, takerBuyBaseAssetVolume, takerBuyQuoteAssetVolume);
    }

    @Override
    public String toString() {
        return "BinanceWebsocketKline{" +
                "openTime=" + openTime +
                ", closeTime=" + closeTime +
                ", pair=" + pair +
                ", interval=" + interval +
                ", openOrderNo=" + openOrderNo +
                ", closeOrderNo=" + closeOrderNo +
                ", open=" + open +
                ", close=" + close +
                ", high=" + high +
                ", low=" + low +
                ", volume=" + volume +
                ", numberOfTrades=" + numberOfTrades +
                ", isClose=" + isClose +
                ", quoteAssetVolume=" + quoteAssetVolume +
                ", takerBuyBaseAssetVolume=" + takerBuyBaseAssetVolume +
                ", takerBuyQuoteAssetVolume=" + takerBuyQuoteAssetVolume +
                '}';
    }


    // @Override
    // public String toString() {
    //     return "Balance[currency=" + currency + ", free=" + free + ", locked=" + locked + "]";
    // }
}
