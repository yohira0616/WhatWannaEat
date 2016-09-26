var gulp = require('gulp');

gulp.task('default', function () {
    return gulp.src('templates/**/*.html')
        .pipe(gulp.dest('../../../build/resources/main/templates'));
});

gulp.task('watch', function () {
    gulp.watch('templates/**/*.html', ['default']);

});