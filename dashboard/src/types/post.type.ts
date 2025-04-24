import { z } from "zod";

const PostSchema = z.object({
  id: z.string(),
  title: z.string().nonempty({ message: "제목이 없습니다." }),
  content: z.string(),
  createdTime: z.string(),
  modifiedTime: z.string(),
  author: z.string(),
  view: z.number(),
});

export type Post = z.infer<typeof PostSchema>;

export type PostSummary = Pick<Post, "id" | "title" | "createdTime">;

export type PostRequest = Omit<Post, "id">;
