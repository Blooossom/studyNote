import { z } from "zod";

const UserSchema = z.object({
  id: z.string().uuid(),
  name: z.string(),
  email: z.string(),
  password: z.string(),
  phone: z.string(),
});

export type User = z.infer<typeof UserSchema>;

export type SignUpRequest = Omit<User, "id">;

export type SignInRequest = Pick<User, "email" | "password">;

export type DeleteUser = Pick<User, "email" | "password">;

const ChangePasswordRequestSchema = z.object({
  email: z.string(),
  oldPassword: z.string(),
  newPassword: z.string(),
  confirmPassword: z.string(),
});

export type ChangePasswordRequest = z.infer<typeof ChangePasswordRequestSchema>;

export type GetUserParams = {
  email: string;
};
