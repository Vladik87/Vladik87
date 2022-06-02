package converter;

import dto.Account;

public class AccountConverter {

    private AccountConverter() {}

    public static String toCsvString(final Account account) {
        StringBuilder sb = new StringBuilder();
        sb.append(account.getId()).append(",");
        sb.append(account.getAmount()).append(",");
        sb.append(account.getUserId());

        return sb.toString();
    }

    public static Account toObject(final String csvString) {
        String[] strings = csvString.split(",");
        int i = 0;

        Account account = new Account();
        account.setId(Long.parseLong(strings[i++]));
        account.setAmount(Integer.parseInt(strings[i++]));
        account.setUserId(Long.parseLong(strings[i++]));

        return account;
    }
}
