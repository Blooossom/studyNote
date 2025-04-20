import { ReactElement } from "react";
import PostSummary from "@/feature/PostSummary.tsx";
import Paging from "@/feature/Paging.tsx";
import { studyPosts } from "@/const/const.ts";

const Content = (): ReactElement => {
  const temp = [1, 2, 3, 4, 5, 6];
  return (
    <div className={`text-5xl bg-pink-100/50 items-center justify-center p-11`}>
      <ul
        className={`grid gap-4 max-w-full grid-cols-[repeat(auto-fill,minmax(500px,1fr))]`}
      >
        {studyPosts.map((post, index) => (
          <PostSummary key={index} post={post} />
        ))}
      </ul>
      <Paging />
    </div>
  );
};

export default Content;
