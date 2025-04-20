import { z } from "zod";

const PostSchema = z.object({
  title: z.string(),
  createdTime: z.string(),
});

export type Post = z.infer<typeof PostSchema>;