public class BuildBank {
    public static void main(String[] args) {

    }
}

class Bank {
    long[] balance;
    int count;

    public Bank(long[] balance) {
        count = balance.length;
        this.balance = new long[balance.length];
        System.arraycopy(balance, 0, this.balance, 0, balance.length);

    }

    public boolean transfer(int account1, int account2, long money) {
        if (account1 > count || account2 > count) {
            return false;
        }
        if (balance[account1 - 1] >= money) {
            balance[account1 - 1] -= money;
            balance[account2 - 1] += money;
            return true;
        } else {
            return false;
        }

    }

    public boolean deposit(int account, long money) {
        if (account > count) {
            return false;
        }
        balance[account - 1] += money;
        return true;

    }

    public boolean withdraw(int account, long money) {
        if (account > count) {
            return false;
        }
        if (balance[account - 1] < money) {
            return false;
        }
        balance[account - 1] -= money;
        return true;

    }
}
