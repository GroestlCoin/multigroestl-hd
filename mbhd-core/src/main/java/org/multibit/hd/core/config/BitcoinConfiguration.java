package org.multibit.hd.core.config;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.common.collect.Maps;
import org.joda.money.CurrencyUnit;

import java.util.Map;

/**
 * <p>Configuration to provide the following to application:</p>
 * <ul>
 * <li>Configuration of Bitcoin related items</li>
 * </ul>
 *
 * @since 0.0.1
 *  
 */
public class BitcoinConfiguration {

  /**
   * Start with MICON since it provides pleasing amounts and iconography
   */
  private String bitcoinSymbol = "MICON";

  private String decimalSeparator = ".";
  private String groupingSeparator = ",";

  private boolean currencySymbolLeading = true;

  @JsonIgnore
  private CurrencyUnit localCurrencyUnit = CurrencyUnit.USD;

  private String localCurrencySymbol = "$";
  private int localDecimalPlaces = 2;

  /**
   * Start with Bitstamp since it provides USD (the global reserve currency)
   */
  private String currentExchange = "BITSTAMP";

  /**
   * The exchange API keys (required for OER and some rate-limited exchanges)
   */
  private Map<String, String> exchangeApiKeys = Maps.newHashMap();

  /**
   * <p>Default constructor uses the default locale</p>
   */
  public BitcoinConfiguration() {
  }

  /**
   * @return A deep copy of this object
   */
  public BitcoinConfiguration deepCopy() {

    BitcoinConfiguration configuration = new BitcoinConfiguration();

    configuration.setBitcoinSymbol(getBitcoinSymbol());
    configuration.setCurrencySymbolLeading(isCurrencySymbolLeading());

    configuration.setDecimalSeparator(getDecimalSeparator());
    configuration.setGroupingSeparator(getGroupingSeparator());
    configuration.setLocalDecimalPlaces(getLocalDecimalPlaces());

    configuration.setLocalCurrencyUnit(getLocalCurrencyUnit());
    configuration.setLocalCurrencySymbol(getLocalCurrencySymbol());

    configuration.setCurrentExchange(getCurrentExchange());
    configuration.setExchangeApiKeys(getExchangeApiKeys());

    return configuration;
  }

  /**
   * @return The Bitcoin symbol to use (compatible with BitcoinSymbol)
   */
  public String getBitcoinSymbol() {
    return bitcoinSymbol;
  }

  public void setBitcoinSymbol(String bitcoinSymbol) {
    this.bitcoinSymbol = bitcoinSymbol;
  }

  /**
   * @return The current exchange (e.g. "BITSTAMP" from <code>ExchangeKey</code>) providing access to the current exchange rate provider
   */
  public String getCurrentExchange() {
    return currentExchange;
  }

  public void setCurrentExchange(String currentExchange) {
    this.currentExchange = currentExchange;
  }

  /**
   * @return The decimal separator
   */
  public String getDecimalSeparator() {
    return decimalSeparator;
  }

  public void setDecimalSeparator(String separator) {
    this.decimalSeparator = separator;
  }

  /**
   * @return The grouping separator
   */
  public String getGroupingSeparator() {
    return groupingSeparator;
  }

  public void setGroupingSeparator(String groupingSeparator) {
    this.groupingSeparator = groupingSeparator;
  }


  public void setCurrencySymbolLeading(boolean currencySymbolLeading) {
    this.currencySymbolLeading = currencySymbolLeading;
  }

  /**
   * @return True if the currency symbol should lead the numerical element which is always read left to right
   */
  public boolean isCurrencySymbolLeading() {
    return currencySymbolLeading;
  }

  /**
   * @return The number of decimal places to show for the local currency
   */
  public int getLocalDecimalPlaces() {
    return localDecimalPlaces;
  }

  public void setLocalDecimalPlaces(int localDecimalPlaces) {
    this.localDecimalPlaces = localDecimalPlaces;
  }

  /**
   * @return The local currency unit (e.g. USD, GBP etc for use with local currencies in Joda Money)
   */
  public CurrencyUnit getLocalCurrencyUnit() {
    return localCurrencyUnit;
  }

  /**
   * @param localCurrencyUnit The local currency unit
   */
  public void setLocalCurrencyUnit(CurrencyUnit localCurrencyUnit) {
    this.localCurrencyUnit = localCurrencyUnit;
  }

  /**
   * @return The local currency symbol (e.g. "$", "£" etc)
   */
  public String getLocalCurrencySymbol() {
    return localCurrencySymbol;
  }

  /**
   * @param localCurrencySymbol The local currency symbol
   */
  public void setLocalCurrencySymbol(String localCurrencySymbol) {
    this.localCurrencySymbol = localCurrencySymbol;
  }

  /**
   * @return The exchange API keys (only OER at present, but others could be added using a "key | value" approach)
   */
  public Map<String, String> getExchangeApiKeys() {
    return exchangeApiKeys;
  }

  public void setExchangeApiKeys(Map<String, String> exchangeApiKeys) {
    this.exchangeApiKeys = exchangeApiKeys;
  }
}
