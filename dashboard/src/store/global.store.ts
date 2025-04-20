import { create } from "zustand/react";

type GlobalTab = "STUDY" | "PROJECT" | "SKILL";

type GlobalState = {
  tab: GlobalTab;
  tag: string;
  actions: {
    setTab: (tab: GlobalTab) => void;
    setTag: (tag: string) => void;
  };
};

const initialState: Omit<GlobalState, "actions"> = {
  tab: "STUDY",
  tag: "전체",
};

const useGlobalStore = create<GlobalState>((set) => ({
  ...initialState,
  actions: {
    setTab: (tab) => set({ tab: tab }),
    setTag: (tag) => set({ tag: tag }),
  },
}));

export const useGlobalTab = () => useGlobalStore((state) => state.tab);

export const useGlobalTag = () => useGlobalStore((state) => state.tag);
export const useGlobalActions = () => useGlobalStore((state) => state.actions);
