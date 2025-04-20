import { ReactElement } from "react";
import {
  Sidebar,
  SidebarContent,
  SidebarGroup,
  SidebarGroupContent,
  SidebarGroupLabel,
  SidebarMenu,
  SidebarMenuButton,
  SidebarMenuItem,
  SidebarMenuSub,
  SidebarMenuSubButton,
  SidebarMenuSubItem,
} from "@/components/ui/sidebar.tsx";
import {
  Collapsible,
  CollapsibleContent,
  CollapsibleTrigger,
} from "@/components/ui/collapsible.tsx";
import {
  projectsCategories,
  projectTags,
  studyCategories,
  studyTags,
} from "@/const/const.ts";
import {useGlobalActions, useGlobalTab} from "@/store/global.store.ts";

const Side = (): ReactElement => {
  const globalTab = useGlobalTab();
  const setGlobalTag = useGlobalActions().setTag;

  const categories =
    globalTab === "STUDY" ? studyCategories : projectsCategories;

  const tags = globalTab === "STUDY" ? studyTags : projectTags;

  return (
    <Sidebar>
      <SidebarContent>
        <SidebarGroup>
          <SidebarGroupLabel>Study Note</SidebarGroupLabel>
          <SidebarGroupContent>
            <SidebarMenu>
              {categories.map((item) => (
                <Collapsible className="group/collapsible">
                  <SidebarMenuItem key={item.title}>
                    <CollapsibleTrigger asChild>
                      <SidebarMenuButton asChild onClick={() => setGlobalTag(item.title)}>
                        <a href={item.url}>
                          <item.icon />
                          <span>{item.title}</span>
                        </a>
                      </SidebarMenuButton>
                    </CollapsibleTrigger>
                    <CollapsibleContent>
                      <SidebarMenuSub>
                        {tags
                          .filter((tag) => tag.category === item.title)
                          .map((el) => (
                            <SidebarMenuSubItem >
                              <SidebarMenuSubButton onClick={() => setGlobalTag(el.title)}>
                                <span>{el.title}</span>
                              </SidebarMenuSubButton>
                            </SidebarMenuSubItem>
                          ))}
                      </SidebarMenuSub>
                    </CollapsibleContent>
                  </SidebarMenuItem>
                </Collapsible>
              ))}
            </SidebarMenu>
          </SidebarGroupContent>
        </SidebarGroup>
      </SidebarContent>
    </Sidebar>
  );
};

export default Side;
