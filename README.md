

# react-native-multitask-blur

Blur screen on switch mode with specific screen

## Installation

```sh
npm install react-native-multitask-blur
```
#### iOS
* In AppDelegate.m
  ```
    @implementation AppDelegate
    ...
    NSNumber* blur = 0;
    ...
    - (BOOL)application:(UIApplication *)application didFinishLaunchingWithOptions:(NSDictionary *)launchOptions
    {
        ...
        [[NSNotificationCenter defaultCenter] addObserver:self
          selector:@selector(receiveTestNotification:)
          name:@"onBlur"
          object:nil];
        ...
    }
    ...
    - (void) receiveTestNotification:(NSNotification *) notification
    {

        if ([[notification name] isEqualToString:@"onBlur"]){
            NSDictionary* userInfo = notification.userInfo;
            NSNumber* isBlur = (NSNumber*)userInfo[@"isBlur"];
            blur = isBlur;
            NSLog (@"%@", isBlur);
        }
            
    }
    ...
    
    - (void)applicationWillResignActive:(UIApplication *)application{
        ...
        if(blur.intValue == 1){
            UIBlurEffect *blurEffect = [UIBlurEffect effectWithStyle:UIBlurEffectStyleDark];
            UIVisualEffectView *blurEffectView = [[UIVisualEffectView alloc] initWithEffect:blurEffect];
            //always fill the view
            blurEffectView.frame = self.window.bounds;
            blurEffectView.autoresizingMask = UIViewAutoresizingFlexibleWidth | UIViewAutoresizingFlexibleHeight;
            blurEffectView.tag = 181099;
            [self.window addSubview:blurEffectView];
        }
        ...
    }

    - (void)applicationDidBecomeActive:(UIApplication *)application{
        ...
        [[self.window viewWithTag:181099] removeFromSuperview];
        ...
    }
  ```

#### Android
* No need to config 😂.
## Usage

```js
import MultitaskBlur from "react-native-multitask-blur";

// ...

MultitaskBlur.blur(); // For blur on multitask switch mode
MultitaskBlur.unBlur(); // For unblur on multitask switch mode
```

## Demo iOS

<img src="example/Demo.gif" width="250" height="450"/>

## Demo Android
<img src="https://user-images.githubusercontent.com/47242981/132122250-cd297d50-82c7-4f71-a94b-a8c4ba7d6cd7.gif" width="250" height="450"/>


## Contributing

See the [contributing guide](CONTRIBUTING.md) to learn how to contribute to the repository and the development workflow.

## License

MIT
