import { NativeModules } from 'react-native';

type MultitaskBlurType = {
  multiply(a: number, b: number): Promise<number>;
};

const { MultitaskBlur } = NativeModules;

export default MultitaskBlur as MultitaskBlurType;
