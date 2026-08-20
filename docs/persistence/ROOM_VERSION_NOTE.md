# Room Version Note

The current persistence baseline uses Room 2.8.4 with KSP.

Android Developers currently document Room 2.8.4 as the stable Room 2.x dependency line. Room 3.0.1 is also available, but it introduces the `androidx.room3` artifact family and additional migration considerations. The current project therefore stays on Room 2.8.4 for this bounded persistence baseline rather than changing the dependency family mid-phase.

The decision can be revisited through a documented architecture decision after the application build baseline is continuously verified.
