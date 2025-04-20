import { ReactElement } from "react";
import Nav from "@/feature/Nav.tsx";
import { clsx } from "clsx";
import LoginDialog from "@/feature/LoginDialog.tsx";
import User from "@/feature/User.tsx";

interface Props {
  open: boolean;
}
const Header = (props: Props): ReactElement => {
  return (
    <section
      className={clsx(
        `sticky top-0 z-50 flex pt-2 bg-lime-100 h-16 ml-auto`,
          props.open ? `left-64 w-[calc(100vw_-_256px)]` : `left-14 w-[calc(100vw_-_56px)]`,
      )}
    >
      <Nav />
      <LoginDialog dialogTrigger={<User />} />
    </section>
  );
};

export default Header;
