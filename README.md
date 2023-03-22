# VIIP - VIm Interactive Printer

Print any source code using Vim. Ported of my original Ruby's [source2pdf](https://github.com/agilecreativity/source2pdf) to Clojure.

![](https://github.com/burinc/viip/raw/main/screenshot.png)

- Sample [pdf output](https://github.com/burinc/viip/blob/main/viip-codes.pdf) for this project.
- With [Fira Code - Light Mode ](https://github.com/burinc/viip/blob/main/code-github-fira-code.pdf) - using `github` theme.
- With [Fira Code - Dark Mode](https://github.com/burinc/viip/blob/main/code-onehalfdark-fira-code.pdf) - using `onehalfdark` theme.

## Requirement

- Working installation of [wkhtmltopdf](https://wkhtmltopdf.org)
- Working installation of [ghostscript](https://www.ghostscript.com)
- Working installation of [Vim](https://www.vim.org) with appropriate colorscheme
- Working installation of [xpdfreader](https://www.xpdfreader.com) needed for `pdfinfo` command
- Working installation of [GraalVM](https://www.graalvm.org) need to build native-image - need to set `GRAALVM_HOME`

## Development/Build

``` sh
bb tasks
```

``` text
clean
build                     Build classes and uberjar
graalvm                   Checks GRAALVM_HOME env var
native-image-uber         Builds native image from uber
native-image-uber-test    Run native image built from uber
native-image-classes      Builds native image from classes
native-image-classes-test Run native image built from classes
native-image-test         Run integration tests
```

Then try the following:

``` sh
bb clean
bb build
bb native-image-test

# If things goes as plan then you would get the native binary in ./target/viip
# You can optionally copy this to your $PATH e.g. ~/bin
mkdir -p ~/bin
\cp ./target/viip ~/bin/viip
```

## Basic Usage

### Help

``` sh
Usage:
  viip [options] --base-dir=<base-dir> --exts=<exts> --output-file=<output-file> [ --preset=<preset> | --color-scheme=<color-scheme> --font-name=<font-name> ]
  viip --list-presets
  viip --version
  viip --help

Options:
  -b, --base-dir=<base-dir>          Base directory [default: .]
  -e, --exts=<exts>                  Extension to print [default: clj,cljc,cljs ]
  -p, --preset=<preset>              Preset to use [default: seoul256-dark]
  -o, --output-file=<output-file>    Output file [default: codes.pdf]
  -c, --color-scheme=<color-scheme>  Color scheme to use [default: jellybeans]
  -f, --font-name=<font-name>        Font name to use [default: Fira Code]
  -z, --paper-size=<paper-size>      Output paper size to use [default: letter]
  -n, --line-numbers                 Print line numbers
  -t, --title=<title>                Title to use [default: vim-interactive-printer]
  -a, --author=<author>              Author for the document [default: viip]
  -s, --tags=<tags>                  Tags to use [default: codes,pdf,command-line]
  -l, --list-presets                 List available presets
  -h, --help                         Print help
  -v, --version                      Display version information

  # ------------------------------------------------------------ ##
  # Common Usage:
  # ------------------------------------------------------------ ##
  ~/bin/viip -b . -e clj,cljc,cljs -c github -f "Fira Code"       -t viip-demo -a viip -o code-github-fira-code.pdf
  ~/bin/viip -b . -e clj,cljc,cljs -c github -f "Fira Code Mono"  -t viip-demo -a viip -o code-github-fira-code-mono.pdf
  ~/bin/viip -b . -e clj,cljc,cljs -c github -f "Inconsolata"     -t viip-demo -a viip -o code-github-inconsolata.pdf

  ~/bin/viip -b . -e clj,cljc,cljs -c envy -f "Fira Code"       -t viip-demo -a viip -o code-envy-fira-code.pdf
  ~/bin/viip -b . -e clj,cljc,cljs -c envy -f "Fira Code Mono"  -t viip-demo -a viip -o code-envy-fira-code-mono.pdf
  ~/bin/viip -b . -e clj,cljc,cljs -c envy -f "Inconsolata"     -t viip-demo -a viip -o code-envy-inconsolata.pdf

  ~/bin/viip -b . -e clj,cljc,cljs -c onehalflight -f "Fira Code"      -t viip -a "Vim Interactive Printer" -o code-onehalflight-fira-code.pdf
  ~/bin/viip -b . -e clj,cljc,cljs -c onehalflight -f "Fira Code Mono" -t viip -a "Vim Interactive Printer" -o code-onehalflight-fira-code-mono.pdf
  ~/bin/viip -b . -e clj,cljc,cljs -c onehalflight -f "Inconsolata"    -t viip -a "Vim Interactive Printer" -o code-onehalflight-inconsolata.pdf

  ~/bin/viip -b . -e clj,cljc,cljs -c onehalfdark -f "Fira Code"       -t viip -a "Vim Interactive Printer" -o code-onehalfdark-fira-code.pdf
  ~/bin/viip -b . -e clj,cljc,cljs -c onehalfdark -f "Fira Code Mono"  -t viip -a "Vim Interactive Printer" -o code-onehalfdark-fira-code-mono.pdf
  ~/bin/viip -b . -e clj,cljc,cljs -c onehalfdark -f "Inconsolata"     -t viip -a "Vim Interactive Printer" -o code-onehalfdark-inconsolata.pdf
  ~/bin/viip -b . -e clj,cljc,cljs -c onehalfdark -f "Fira Code"       -t viip -a "Vim Interactive Printer" -o code-onehalfdark-fira-code.pdf
  ~/bin/viip -b . -e clj,cljc,cljs -c onehalfdark -f "Fira Code Mono"  -t viip -a "Vim Interactive Printer" -o code-onehalfdark-fira-code-mono.pdf
  ~/bin/viip -b . -e clj,cljc,cljs -c onehalfdark -f "Inconsolata"     -t viip -a "Vim Interactive Printer" -o code-onehalfdark-inconsolata.pdf

  ~/bin/viip -b . -e clj,cljc,cljs -c jellybeans  -f "Fira Code"       -t viip -a "Vim Interactive Printer" -o code-jellybeans-fira-code.pdf
  ~/bin/viip -b . -e clj,cljc,cljs -c jellybeans  -f "Fira Code Mono"  -t viip -a "Vim Interactive Printer" -o code-jellybeans-fira-code-mono.pdf
  ~/bin/viip -b . -e clj,cljc,cljs -c jellybeans  -f "Inconsolata"     -t viip -a "Vim Interactive Printer" -o code-jellybeans-inconsolata.pdf

  ~/bin/viip -b . -e clj,cljc,cljs -c PaperColor -f "Fira Code"       -t viip-demo -a "Vim Interactive Printer" -o code-papercolor-fira-code.pdf
  ~/bin/viip -b . -e clj,cljc,cljs -c PaperColor -f "Fira Code Mono"  -t viip-demo -a "Vim Interactive Printer" -o code-papercolor-fira-code-mono.pdf
  ~/bin/viip -b . -e clj,cljc,cljs -c PaperColor -f "Inconsolata"     -t viip-demo -a "Vim Interactive Printer" -o code-papercolor-inconsolata.pdf

  # ------------------------------------------------------------ ##
  ## Show help
  viip -h

  # ------------------------------------------------------------ ##
  ## Show version
  viip -v
```

### Example

``` sh
~/bin/viip -b . -e clj -p seoul256-dark -z letter -t "Vim Printer Demo" -o viip-codes.pdf -x /Users/bchoomnuan/codes/b12n-viip/resources/pdfmarks.tmpl
```

Which generate the output in the screenshot above.
