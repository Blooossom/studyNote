import "./App.css";
import Header from "@/layout/Header.tsx";
import Side from "@/layout/Side.tsx";
import { SidebarProvider, SidebarTrigger } from "@/components/ui/sidebar.tsx";
import { useState } from "react";
import { cn } from "@/lib/utils.ts";
import { clsx } from "clsx";
import Main from "@/layout/Main.tsx";

function App() {
  const [open, setOpen] = useState<boolean>(false);
  return (
    <div className={cn(`grid`, open ? `grid-cols-[256px,1fr]` : `grid-cols-[56px,1fr]`)}>
      <Header open={open} />
      <SidebarProvider open={open} onOpenChange={setOpen}>
        <SidebarTrigger
          className={clsx(
            cn(`absolute w-11 h-11 mt-3 items-center justify-center`),
            open ? `left-64` : `left-0`,
          )}
          size={'default'}
        />
        <Side />
      </SidebarProvider>
      <Main open={open} />
    </div>
  );
}

export default App;
