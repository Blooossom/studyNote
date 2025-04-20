import { ReactElement } from "react";
import { useGlobalTag } from "@/store/global.store.ts";

const Title = (): ReactElement => {
  const tag = useGlobalTag();

  return (
    <div
      className={`relative w-full h-full text-black text-4xl items-center justify-center flex`}
    >
      <h1>{tag}</h1>
    </div>
  );
};

export default Title;
