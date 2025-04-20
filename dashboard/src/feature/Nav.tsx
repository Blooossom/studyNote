import { ReactElement } from "react";
import {
  NavigationMenu,
  NavigationMenuItem,
  NavigationMenuLink,
  NavigationMenuList,
  navigationMenuTriggerStyle,
} from "@/components/ui/navigation-menu";
import { useGlobalActions } from "@/store/global.store.ts";

export const Nav = (): ReactElement => {
  const setGlobalTab = useGlobalActions().setTab;
  const setTag = useGlobalActions().setTag
  return (
    <NavigationMenu>
      <NavigationMenuList>
        <NavigationMenuItem onClick={() => {
          setGlobalTab("STUDY");
          setTag('전체')
        }}>
          <NavigationMenuLink className={navigationMenuTriggerStyle()}>
            Study
          </NavigationMenuLink>
        </NavigationMenuItem>
        <NavigationMenuItem onClick={() => setGlobalTab("PROJECT")}>
          <NavigationMenuLink className={navigationMenuTriggerStyle()}>
            Projects
          </NavigationMenuLink>
        </NavigationMenuItem>
        {/*<NavigationMenuItem>*/}
        {/*  <NavigationMenuLink className={navigationMenuTriggerStyle()}>*/}
        {/*    Documentation*/}
        {/*  </NavigationMenuLink>*/}
        {/*</NavigationMenuItem>*/}
      </NavigationMenuList>
    </NavigationMenu>
  );
};
export default Nav;
