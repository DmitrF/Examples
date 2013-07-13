package ua.dfedorenko.money;

public class Sum implements Expression {

	public Sum(Money augend, Money addend) {
		this.augend = augend;
		this.addend = addend;
	}

	public Money augend;
	public Money addend;
	public Money reduce(String to) {
		int amount = augend.amount+addend.amount;
		return new Money(amount,to);
	}

}
