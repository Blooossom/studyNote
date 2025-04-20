import * as React from "react";
import { ReactElement } from "react";
import {
  Dialog,
  DialogContent,
  DialogDescription,
  DialogFooter,
  DialogHeader,
  DialogTitle,
  DialogTrigger,
} from "@/components/ui/dialog.tsx";
import { Button } from "@/components/ui/button.tsx";
import { Label } from "@/components/ui/label.tsx";
import { Input } from "@/components/ui/input.tsx";

interface Props {
  dialogTrigger: React.ReactNode;
}
const LoginDialog = (props: Props): ReactElement => {
  return (
    <Dialog>
      <DialogTrigger asChild className={`bg-transparent items-center justify-center flex`}>
        <Button className={`bg-transparent h-[44px] border-transparent`}>{props.dialogTrigger}</Button>
      </DialogTrigger>
      <DialogContent className="sm:max-w-[425px]">
        <DialogHeader>
          <DialogTitle>로그인</DialogTitle>
          <DialogDescription>
            페이지를 편집하려면 로그인이 필요합니다.
          </DialogDescription>
        </DialogHeader>
        <div className="grid gap-4 py-4">
          <div className="grid grid-cols-4 items-center gap-4">
            <Label htmlFor="email" className="text-right">
              이메일
            </Label>
            <Input
              id="email"
              placeholder="이메일을 입력해주세요."
              className="col-span-3"
            />
          </div>
          <div className="grid grid-cols-4 items-center gap-4">
            <Label htmlFor="password" className="text-right">
              비밀번호
            </Label>
            <Input
              id="password"
              placeholder="비밀번호를 입력해주세요."
              className="col-span-3"
            />
          </div>
        </div>
        <DialogFooter>
          <Button type="submit">로그인</Button>
        </DialogFooter>
      </DialogContent>
    </Dialog>
  );
};

export default LoginDialog;
