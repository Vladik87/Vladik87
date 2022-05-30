package service;

public record UserValidationRequest(String userName,
                                    String password,
                                    String firstName,
                                    String lastName,
                                    String birthDate,
                                    String sex,
                                    String email) {
}
