package dev.fun.app.common.money;

import java.text.NumberFormat;
import java.util.Locale;

public class Money {
	
	private final long value;
	private final NumberFormat currency;
	
	public Money(long value, Locale locale) {
		this.value = value;
		this.currency = NumberFormat.getCurrencyInstance(locale);
	}
	
	public long getValue() {
		return value;
	}
	
	public NumberFormat getCurrency() {
		return currency;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == this) return true;
		if (obj == null || obj.getClass() != this.getClass()) return false;
		Money m = (Money) obj;
		return this.value == m.getValue() && this.currency.equals(m.getCurrency());
	}
	
	@Override
	public int hashCode() {
		int v = (int) (value^(value >>> 32));
		return currency.hashCode() +  v;
	}
	
}
