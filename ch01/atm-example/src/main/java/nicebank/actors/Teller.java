package nicebank.actors;

public interface Teller {
    void withdrawFrom(Account account, int dollars);
}
