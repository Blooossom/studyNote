import { ReactElement } from "react";
import { cn } from "@/lib/utils.ts";
import Title from "@/feature/Title.tsx";
import Content from "@/feature/Content.tsx";

interface Props {
  open: boolean;
}
const Main = (props: Props): ReactElement => {
  return (
    <section
      className={cn(
        `absolute top-16 w-full h-full grid bg-gray-50 overflow-hidden grid-rows-[108px,1fr]`,
        props.open
          ? `left-64 max-w-[calc(100%_-_256px)]`
          : `left-14 max-w-[calc(100%_-_56px)]`,
      )}
    >
      <Title />
      <Content />
    </section>
  );
};

export default Main;
