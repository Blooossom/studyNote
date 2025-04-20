import { ReactElement } from "react";
import { Post } from "@/types/post.type.ts";

interface Props {
  post: Post;
}
const PostSummary = (props: Props): ReactElement => {
  return (
    <li
      className={`flex flex-col gap-3 items-center justify-center border border-black p-6`}
    >
      <div
        className={`h-[200px] w-[350px] items-center border rounded-md border-solid border-gray-200 justify-center bg-amber-100`}
      ></div>
      <div className={`truncate text-2xl`}>{props.post.title}</div>
      <div className={`text-right text-sm flex items-end justify-end`}>{props.post.createdTime}</div>
    </li>
  );
};

export default PostSummary;
